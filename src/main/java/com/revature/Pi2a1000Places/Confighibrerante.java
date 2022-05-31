<hibernate-configuration> 
 <session-factory> 
  <!-- Database connection settings -->
   <property name="connection.driver_class">com.mysql.jdbc.Driver</property> 
   <property name="connection.url">jdbc:mysql://localhost:3306/hibernateDB2</property> 
   <property name="connection.username">root</property> 
   <property name="connection.password">root</property> 

  <!-- JDBC connection pool (use the built-in) -->
   <property name="connection.pool_size">1</property> 

  <!-- SQL dialect -->
   <property name="dialect">org.hibernate.dialect.MySQLDialect</property> 

  <!-- Enable Hibernate's automatic session context management -->
    <property name="current_session_context_class">thread</property> 
  
  <!-- Disable the second-level cache -->
   <property name="cache.provider_class">org.hibernate.cache.NoCacheProvider</property> 

  <!-- Echo all executed SQL to stdout -->
   <property name="show_sql">true</property> 
  
  <!-- Drop and re-create the database schema on startup -->
   <property name="hbm2ddl.auto">update</property> 
    
   <mapping class="com.sdnext.hibernate.tutorial.dto.Student">
      
  </mapping></session-factory> 
 </hibernate-configuration>
f