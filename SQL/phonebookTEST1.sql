create table phoneInfo_basic (
        idx             number(6)       primary key,
        fr_name         varchar2(20)    not null,
        fr_phonenumber  varchar2(20)    not null,
        fr_email        varchar2(20)    default '-',
        fr_address      varchar2(20)    default '-',
        fr_regdate      DATE            default sysdate
);
 
drop table phoneinfo_basic;
create table phoneInfo_univ (
        idx             number(6)       primary key,
        fr_u_major      varchar2(20)    default 'N',
        fr_u_year       number(1)       check (fr_u_year BETWEEN 5 and 1),
        fr_ref          number(7)       not null references phoneinfo_basic(idx)
);
 
 
create table phoneinfo_com(
        idx             number(6)       primary key,
        fr_c_company    varchar2(20)    default 'N',
        fr_ref          number(6)       not null references phoneinfo_basic(idx)
);
 
 
 
-----------------------------------------------------------------------------------
 
create table fr_type(
    friendty      varchar2(5)    unique
);
 
insert into fr_type values ('univ');
insert into fr_type values ('com');
insert into fr_type values ('cafe');
 
 
-----------------------------------------------------------
 
create table phonebook(
    pidx            number(6)        primary key,
    friendtype      varchar2(5)      references fr_type(friendty)
);
 
----------------------------------------------------------------
 -- 시퀀스 생성
create Sequence seq_basic_idx MINVALUE 0 start with 1 INCREMENT BY 1;
create Sequence seq_univ_idx MINVALUE 0 start with 1 INCREMENT BY 1;
create Sequence seq_com_idx MINVALUE 0 start with 1 INCREMENT BY 1;
create Sequence seq_main_idx MINVALUE 0 start with 1 INCREMENT BY 1;

drop sequence seq_basic_idx;
drop sequence seq_univ_idx;
drop sequence seq_com_idx;
drop SEQUENCE seq_main_idx;
----------------------------------------------------------------
select * from phoneinfo_basic;
delete from phoneinfo_basic;

insert into phoneinfo_basic values (seq_basic_idx.nextval, '효선', '01012345678', 'tomnmo@naver.com', '서울', sysdate);
insert into phoneinfo_basic values (seq_basic_idx.nextval, '하하호호', '01098765432', 'ttt_111@naver.com', '경기', sysdate);
insert into phoneinfo_basic values (seq_basic_idx.nextval, '레쓰비', '01087873383', 'a_3@gmail.com', '대전', sysdate);

commit;


------------------------------------------------------------------
select * from phoneinfo_univ;
delete from phoneinfo_univ;
insert into phoneinfo_univ values (seq_univ_idx.nextval, '게임', '4', '1');
insert into phoneinfo_univ values (seq_univ_idx.nextval, '문예창작', '2', '2');
rollback;

select * from phoneinfo_com;
delete from phoneinfo_com;
insert into phoneinfo_com values (seq_com_idx.nextval, 'AI', '3');

------------------------------------------------------------------
select * from phonebook;
delete from phonebook;
insert into phonebook values (seq_main_idx.nextval , 'univ');
insert into phonebook values (seq_main_idx.nextval , 'com');

------------------------------------------------------------------

--drop table testpb1;
--create table testpb1
--as
--select c.FR_REF as ref, fr_name, b.fr_phonenumber, b.fr_email, b.fr_address, b.fr_regdate, c.FR_C_COMPANY
--from phoneinfo_basic b, phoneinfo_com c
--where b.idx=c.fr_ref
--;
--
--select *
--from phoneinfo_basic b NA TURAL JOIN phoneinfo_com c
--;
--
--drop table testpb2;
--
--create table testpb2
--as
--select u.FR_REF as ref, fr_name, b.fr_phonenumber, b.fr_email, b.fr_address, b.fr_regdate, u.fr_u_major,u.fr_u_year
--from phoneinfo_basic b,phoneinfo_univ u
--where b.idx=u.fr_ref
--order by b.idx
--;
--
--select *
--from phoneinfo_basic b NATURAL JOIN phoneinfo_univ u
--;
--
--select *
--from testpb1 NATURAL JOIN testpb2
--;




