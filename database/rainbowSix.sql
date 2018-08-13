create table reseller(
    resellerId number(12) primary key,
    resellerName varchar(32) not null,
    resellerMail varchar(128) not null,
    resellerPhone_pre char(3),
    resellerPhont_suf char(11),
    locale varchar(64) not null,
    address varchar(64) not null
);