package ru.stqa.addressbook.manager;
import io.qameta.allure.Step;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import ru.stqa.addressbook.manager.hbm.GroupRecord;
import ru.stqa.addressbook.manager.hbm.PhoneNumberRecord;
import ru.stqa.addressbook.model.Group;
import ru.stqa.addressbook.model.PhoneNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HibernateHelper extends HelperBase {

    private SessionFactory sessionFactory;

    public HibernateHelper(ApplicationManager manager) {
        super(manager);
        sessionFactory = new Configuration()
                .addAnnotatedClass(PhoneNumberRecord.class)
                .addAnnotatedClass(GroupRecord.class)
                .setProperty(AvailableSettings.URL, "jdbc:mysql://localhost/addressbook?zeroDateTimeBehavior=convertToNull")
                .setProperty(AvailableSettings.USER, "root")
                .setProperty(AvailableSettings.PASS, "")
                .buildSessionFactory();
    }

    static List<Group> convertGroupList(List<GroupRecord> records) {
       return records.stream().map(HibernateHelper::convert).collect(Collectors.toList());
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

    @Step
    public List<Group> getGroupList() {
        return convertGroupList(sessionFactory.fromSession(session -> {
            return session.createQuery("from GroupRecord", GroupRecord.class).list();
        }));
    }

    @Step
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

    public void createNumber(PhoneNumber phoneNumber) {
        sessionFactory.inSession(session -> {
            session.getTransaction().begin();
            session.persist(convert(phoneNumber));
            session.getTransaction().commit();
        });
    }

    @Step
    public List<PhoneNumber> getPhoneNumberList() {
        return convertNumberList(sessionFactory.fromSession(session -> {
            return session.createQuery("from PhoneNumberRecord", PhoneNumberRecord.class).list();
        }));
    }

    public long getPhoneNumberCount() {
        return sessionFactory.fromSession(session -> {
            return session.createQuery("select count (*) from PhoneNumberRecord", long.class).getSingleResult();
        });
    }

    static List<PhoneNumber> convertNumberList(List<PhoneNumberRecord> records) {
        return records.stream().map(HibernateHelper::convert).collect(Collectors.toList());
    }

    private static PhoneNumber convert(PhoneNumberRecord record) {
        return new PhoneNumber().withId("" + record.id)
                .withFirstName(record.firstname)
                .withLastName(record.lastname)
                .withAddress(record.address)
                .withHome(record.home)
                .withMobile(record.mobile)
                .withWork(record.work)
                .withEmail(record.email)
                .withEmail2(record.email2)
                .withEmail3(record.email3);
    }

    private static PhoneNumberRecord convert(PhoneNumber data) {
        var id = data.id();
        if ("".equals(id)) {
            id = "0";
        }

        return new PhoneNumberRecord(Integer.parseInt(id), data.firstname(), data.lastname(),
                data.address(), data.middlename(), data.nickname(), data.company(), data.title());
    }

    @Step
    public List<PhoneNumber> getPhoneNumbersInGroup(Group group) {
        return sessionFactory.fromSession(session -> {
            return convertNumberList(session.get(GroupRecord.class, group.id()).phoneNumbers);
        });
    }
    }


