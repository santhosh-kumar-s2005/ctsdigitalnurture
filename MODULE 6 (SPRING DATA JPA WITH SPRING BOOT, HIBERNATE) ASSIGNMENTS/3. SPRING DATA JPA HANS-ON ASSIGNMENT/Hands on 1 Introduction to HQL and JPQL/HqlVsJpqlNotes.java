package com.cognizant.ormlearn.notes;

/*
 * HQL  - Hibernate Query Language
 * JPQL - Java Persistence Query Language
 *
 * - Both are object-focused query languages similar to SQL
 * - JPQL is a subset of HQL
 * - All JPQL queries are valid HQL queries, but not vice versa
 * - Both allow SELECT, UPDATE, DELETE
 * - HQL additionally allows INSERT
 *
 * HQL Example:
 *   SELECT e FROM Employee e WHERE e.permanent = 1
 *
 * JPQL Example:
 *   SELECT e FROM Employee e WHERE e.salary > 50000
 *
 * Key difference from SQL:
 *   - HQL/JPQL reference Java class names and field names, NOT table/column names
 *   - e.g. Employee (not employee table), e.permanent (not em_permanent column)
 *
 * Reference: https://docs.jboss.org/hibernate/orm/4.3/devguide/en-US/html/ch11.html
 */
public class HqlVsJpqlNotes {
}
