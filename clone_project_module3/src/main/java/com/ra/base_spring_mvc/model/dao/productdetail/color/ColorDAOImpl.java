package com.ra.base_spring_mvc.model.dao.productdetail.color;

import com.ra.base_spring_mvc.model.entity.Color;
import com.ra.base_spring_mvc.model.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class ColorDAOImpl implements ColorDAO{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Color> findAll() {
        Session session= sessionFactory.openSession();
        List<Color> colors=new ArrayList<>();
        try {
            colors=session.createQuery("from Color ", Color.class)
                    .list();

        }catch (Exception e){
            e.printStackTrace();

        }finally {
            session.close();
        }
        return colors;
    }
}
