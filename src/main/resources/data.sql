-- Basic data created to run the application
insert into product(product_Id, product_Name, product_type,manufacturing_Date,expiry_date, product_price,is_sold,sold_to)
values(1, 'Ramayaan', 'BOOK', sysdate(), sysdate(),1200,0,null);
insert into product(product_Id, product_Name, product_type,manufacturing_Date,expiry_date, product_price,is_sold,sold_to)
values(2, 'Samsung 13A', 'ELECTRONIC', sysdate(), sysdate(),15000,1, 'anuj.pankaj@zensar.com');
insert into product(product_Id, product_Name, product_type,manufacturing_Date,expiry_date, product_price,is_sold,sold_to)
values(3, 'Samsung TV Elite 40 inch', 'BOOK', sysdate(), sysdate(),4200,0,null);
insert into product(product_Id, product_Name, product_type,manufacturing_Date,expiry_date, product_price,is_sold,sold_to)
values(4, 'RedMi Note 4', 'ELECTRONIC', sysdate(), sysdate(),10000,0,null);
insert into product(product_Id, product_Name, product_type,manufacturing_Date,expiry_date, product_price,is_sold,sold_to)
values(5, 'Dinning chair table set', 'FURNITURE', sysdate(), sysdate(),32000,0,null);
insert into product(product_Id, product_Name, product_type,manufacturing_Date,expiry_date, product_price,is_sold,sold_to)
values(6, 'Smasung grilled oven 12 L', 'ELECTRONIC', sysdate(), sysdate(),5000,0,null);

