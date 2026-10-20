insert ignore into customer_details(customer_id, full_name, email, phone_number, customer_location )
       values (1, 'kavin', 'kavin1234@gmail.com', '93442253412', 'karaikudi'),
        (2, 'keerthivasan', 'keerthi1992@gmail.com', '93442253412', 'Trichy'),
        (3, 'Abdullah', 'abdullahkhan@gmail.com', '93442253231', 'Chennai');


insert ignore into warehouse(warehouse_product_name, warehouse_location, warehouse_product_stock)
    values('Central-1001',  'Chennai', 10000);

insert ignore into local_hub(hub_name, hub_location, warehouse_id)
       values( 'Hub-A', 'Karaikudi', 1),
              ('Hub-B', 'Madurai', 1);

insert ignore into products (product_name, product_stock, product_price, warehouse_id )
values ('Brass Pipe Valve 1/2 inch', 500, 2134, 1),
       ('Commercial HVAC Air Filter', 1200, 123.4, 1),
       ('Heavy Duty Circuit Breaker 20A', 800, 654.78, 1);

insert ignore into hub_products(hub_stock, hub_id, product_id)
values (30, 1, 1),
       (20, 2, 3),
       (40, 1, 2);