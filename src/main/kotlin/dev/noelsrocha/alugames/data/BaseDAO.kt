package dev.noelsrocha.alugames.data

import javax.persistence.EntityManager

abstract class BaseDAO<TModel>(protected val manager: EntityManager) {
    abstract fun toEntity(value: TModel)

    abstract fun getList(): List<TModel>
    open fun insert(value: TModel) {
        val entity = toEntity(value)
        manager.transaction.begin()
        manager.persist(entity)
        manager.transaction.commit()
    }
}