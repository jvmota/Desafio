package com.example.desafio.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.BeanUtils;

import com.example.desafio.model.EntityTarefa;
import com.example.desafio.model.Tarefa;

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

	@Override
	public EntityTarefa atualizaTarefa(Tarefa tarefa, Integer ID) {
		EntityTarefa tarefaModificada = new EntityTarefa();
		this.session.beginTransaction();
		this.session.load(tarefaModificada, ID);
		BeanUtils.copyProperties(tarefa, tarefaModificada);
		this.session.update(tarefaModificada);
		this.session.getTransaction().commit();
		return tarefaModificada;
	}
	

}
