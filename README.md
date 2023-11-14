datebase名 /　todo  
table名　/　todo  

CREATE TABLE IF NOT EXISTS todo (  
  id bigint(20) NOT NULL AUTO_INCREMENT,  
  task varchar(255),  
  date date,  
  status tinyint(1),  
  PRIMARY KEY (id)  
);
