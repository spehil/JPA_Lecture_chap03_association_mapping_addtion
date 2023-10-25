package com.ohgiraffers.section04.onetoone.subsection02;

import org.junit.jupiter.api.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OneToOneAssociationTests {

    private  static EntityManagerFactory entityManagerFactory;

    private EntityManager entityManager;

    @BeforeAll
    public  static void initFactoty(){

        entityManagerFactory = Persistence.createEntityManagerFactory("jpatest");

    }

    @BeforeEach//EntityManager는 매번 만들어져야하므로 test하나가 수행되기 전마다 수행되는 BeforeEach 작성
    public void initManager(){

        entityManager = entityManagerFactory.createEntityManager();

    }

    @AfterAll //BeforeAll과 AfterAll은 static으로 작성한다.
    public  static  void closeFactory(){

        entityManagerFactory.close();
    }


    @AfterEach
    public void closeManager(){
        entityManager.close();
    }


    @Test
    public void 외래키가_user에_있는_경우_양방향_연관관계_테스트() {
        //given
        Long userCode = 1L;
        //when
        User user = entityManager.find(User.class, userCode);
        //then
        assertNotNull(user);
        System.out.println(user);
        System.out.println(user.getUserInfo());
        System.out.println(user.getUserInfo().getUser());
    }

    }


