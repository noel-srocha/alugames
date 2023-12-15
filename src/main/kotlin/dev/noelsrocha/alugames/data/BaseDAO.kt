package dev.noelsrocha.alugames.data

import javax.persistence.EntityManager

abstract class BaseDAO<TModel, TEntity>(private val manager: EntityManager, private val entityType: Class<TEntity>) {
    abstract fun toEntity(value: TModel): TEntity
    abstract fun toModel(entity: TEntity): TModel

    open fun getById(id: Int): TModel {
        val query = manager.createQuery("FROM ${entityType.simpleName} WHERE ID=:id", entityType)
        query.setParameter("ID", id)
        return toModel(query.singleResult)
    }

    open fun getList(): List<TModel> {
        val query = manager.createQuery("FROM ${entityType.simpleName}", entityType)

        return query.resultList.map { entity -> toModel(entity) }
    }

    open fun insert(value: TModel) {
        val entity = toEntity(value)
        manager.transaction.begin()
        manager.persist(entity)
        manager.transaction.commit()
    }

    open fun delete(id: Int) {
        val query = manager.createQuery("FROM ${entityType.simpleName} WHERE ID=:id", entityType)
        query.setParameter("ID", id)

        manager.transaction.begin()
        manager.remove(query.singleResult)
        manager.transaction.commit()
    }
}