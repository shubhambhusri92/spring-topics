1.We can use either hibernate save or jpa persist method for db 
for getting hibernate session from Entity manager  using //Session unwrap = entityManager.unwrap(Session.class);

2. When you create a new entity object, it’s in the transient lifecycle state. It does not map any database record.
Author a = new Author();
a.setFirstName("Thorben");
a.setLastName("Janssen");

You need to attach the entity to a persistence context so that it becomes managed and gets persisted in the database. You can either use JPA’s persist or Hibernate’s save method to do that. Both methods seem to do the same, but there are a few differences.

3. Another obvious difference between these 2 methods is their return type. JPA’s persist method returns void and Hibernate’s save method returns the primary key of the entity.


******** LINK FOR MERGE DETACH AND CLEAR : https://thorben-janssen.com/persist-save-merge-saveorupdate-whats-difference-one-use/



4. Refresh: By invoking EntityManager#refresh(entity), we can synchronize the current persistence context to the underlying database. In other words, by invoking this method, we can reload the state of a managed entity instance from the database. The existing state of the entity instance is overwritten.

The refresh operation is cascaded to entities referenced by this entity if the attribute cascade=REFRESH or cascade=ALL are used (check out cascading tutorial).




5. DIFFERENT ISOLATION/PROPOGATION LEVELS:
    
• Propagation level: REQUIRED(Default), SUPPORTS, MANDATORY, REQUIRES_NEW, NOT_SUPPORTED, NEVER, NESTED

• Isolation level: READ_UNCOMMITTED, READ_COMMITTED, REPEATABLE_READ, SERIALIZABLE
   
     
    

LINK FOR PROPOGATION: 1. https://www.javainuse.com/spring/boot-transaction-propagation
2. https://medium.com/@aleksanderkolata/use-case-02-spring-transactional-requires-new-propagation-mode-cb7c16e1dd16

