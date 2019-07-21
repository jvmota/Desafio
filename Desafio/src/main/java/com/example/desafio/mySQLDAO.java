package com.example.desafio;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class mySQLDAO implements Database{
	
	Session session;
	HibernateUtils hibernate = new HibernateUtils();
	@Override
	public void openConnection() {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		this.session = sessionFactory.openSession();
	}
	
	@Override
	public EntityTarefa saveTarefa(EntityTarefa tarefa) {
		this.session.beginTransaction();
		this.session.save(tarefa);
		this.session.getTransaction().commit();
		
		return tarefa;
	}
	
	@Override
	public EntityTarefa loadTarefa(Integer ID) {
		EntityTarefa tarefa = new EntityTarefa();
		this.session.beginTransaction();
		this.session.load(tarefa, ID);
		this.session.getTransaction().commit();
		return tarefa;
	}

	@Override
	public void closeConnection() {
		this.session.close();
	}

	@Override
	public List<EntityTarefa> retornaTarefas() {
		this.session.beginTransaction();
		Criteria criteria = this.session.createCriteria(EntityTarefa.class);
		this.session.getTransaction().commit();
		List<EntityTarefa> tarefas = criteria.list();
		return tarefas;
	}
	

}