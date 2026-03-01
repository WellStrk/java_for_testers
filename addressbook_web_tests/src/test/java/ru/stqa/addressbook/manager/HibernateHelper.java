package ru.stqa.addressbook.manager;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import ru.stqa.addressbook.manager.hbm.GroupRecord;
import ru.stqa.addressbook.model.Group;

import java.util.ArrayList;
import java.util.List;

public class HibernateHelper extends HelperBase{

    private SessionFactory sessionFactory;

    public HibernateHelper(ApplicationManager manager) {
        super(manager);
        sessionFactory = new Configuration()
                // .addAnnotatedClass(Book.class)
                .addAnnotatedClass(GroupRecord.class)
                .setProperty(AvailableSettings.URL, "jdbc:mysql://localhost/addressbook")
                .setProperty(AvailableSettings.USER, "root")
                .setProperty(AvailableSettings.PASS, "")
                .buildSessionFactory();
    }

    static List<Group> convertList(List<GroupRecord> records) {
        List<Group> result = new ArrayList<>();
        for (var record : records) {
            result.add(convert(record));
        }
        return result;
    }

    private static Group convert(GroupRecord record) {
        return new Group("" + record.id, record.name, record.header, record.footer);
    }

    private static GroupRecord convert(Group data) {
        var id = data.id();
        if ("".equals(id)) {
            id = "0";
        }
        return new GroupRecord(Integer.parseInt(id), data.name(), data.header(), data.footer());
    }

    public List<Group> getGroupList() {
        return convertList(sessionFactory.fromSession(session -> {
            return session.createQuery("from GroupRecord", GroupRecord.class).list();
        }));
    }

    public void createGroup(Group group) {
        sessionFactory.inSession(session -> {
            session.getTransaction().begin();
            session.persist(convert(group));
            session.getTransaction().commit();
        });
    }

    public long getGroupCount() {
        return sessionFactory.fromSession(session -> {
            return session.createQuery("select count (*) from GroupRecord", long.class).getSingleResult();
        });
    }
}
