CREATE TABLE "Roles" (
	"id" serial,
	"name" varchar(30),
	CONSTRAINT "Roles_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "User" (
	"id" serial,
	"role_id" integer NOT NULL,
	"userName" varchar(30) NOT NULL UNIQUE,
	"phone" integer NOT NULL UNIQUE,
	"age" integer NOT NULL,
	"adress" serial(255) NOT NULL,
	"moneySpent" integer(255),
	"favouriteCategory_id" varchar(255),
	"coupon_available" integer NOT NULL UNIQUE,
	CONSTRAINT "User_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "Category" (
	"id" integer,
	"name" VARCHAR(255),
	CONSTRAINT "Category_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "Admin" (
	"id" serial NOT NULL,
	"role_id" integer NOT NULL,
	"name" varchar(30) NOT NULL,
	CONSTRAINT "Admin_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "Good" (
	"id" serial NOT NULL,
	"name" varchar(80) NOT NULL UNIQUE,
	"price" integer NOT NULL,
	"amount" integer NOT NULL,
	"category_id" varchar(50) NOT NULL,
	CONSTRAINT "Good_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "Order" (
	"order_status" integer NOT NULL,
	"id" serial NOT NULL,
	"user_id" integer NOT NULL,
	"good_id" integer NOT NULL,
	"coupon_id" integer NOT NULL,
	"total_price" integer NOT NULL,
	"order_date" integer NOT NULL,
	CONSTRAINT "Order_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "Order_status" (
	"id" serial NOT NULL,
	"status" varchar(50) NOT NULL UNIQUE,
	CONSTRAINT "Order_status_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "Coupon" (
	"id" serial NOT NULL,
	"name" varchar(50) NOT NULL UNIQUE,
	"discount" integer NOT NULL,
	CONSTRAINT "Coupon_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);




ALTER TABLE "User" ADD CONSTRAINT "User_fk0" FOREIGN KEY ("id") REFERENCES "Order"("user_id");
ALTER TABLE "User" ADD CONSTRAINT "User_fk1" FOREIGN KEY ("role_id") REFERENCES "Roles"("id");
ALTER TABLE "User" ADD CONSTRAINT "User_fk2" FOREIGN KEY ("favouriteCategory_id") REFERENCES "Category"("id");
ALTER TABLE "User" ADD CONSTRAINT "User_fk3" FOREIGN KEY ("coupon_available") REFERENCES "Coupon"("id");


ALTER TABLE "Admin" ADD CONSTRAINT "Admin_fk0" FOREIGN KEY ("role_id") REFERENCES "Roles"("id");

ALTER TABLE "Good" ADD CONSTRAINT "Good_fk0" FOREIGN KEY ("category_id") REFERENCES "Category"("id");

ALTER TABLE "Order" ADD CONSTRAINT "Order_fk0" FOREIGN KEY ("order_status") REFERENCES "Order_status"("id");
ALTER TABLE "Order" ADD CONSTRAINT "Order_fk1" FOREIGN KEY ("good_id") REFERENCES "Good"("id");
ALTER TABLE "Order" ADD CONSTRAINT "Order_fk2" FOREIGN KEY ("total_price") REFERENCES "User"("moneySpent");


ALTER TABLE "Coupon" ADD CONSTRAINT "Coupon_fk0" FOREIGN KEY ("id") REFERENCES "Order"("coupon_id");

