package com.shaif.springmvc.Repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.shaif.springmvc.model.Alien;

@Component
public class AlienDao 
{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public List<Alien> getAliens()
	{
		Session session=sessionFactory.getCurrentSession();
	List<Alien> aliens=	session.createQuery("from Alien", Alien.class).list();
		
	return aliens;
	}
}
