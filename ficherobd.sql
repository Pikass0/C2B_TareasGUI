select * from tareas where estado like 'in progress';

create table tareas(
    ID_TAREA int not null generated always as identity,
    DESCRIPCION VARCHAR(30) NOT NULL,
    ESTADO VARCHAR(11) NOT NULL DEFAULT 'TODO',
    PRIMARY KEY (ID_TAREA),
    CHECK (ESTADO IN('TODO', 'IN PROGRESS', 'DONE'))
);
INSERT INTO TAREAS (DESCRIPCION, ESTADO) VALUES ('Hacer 5', 'TODO');
--                                                 ('Hacer pool conexiones', 'TODO'),
--                                                 ('Hacer tareas', 'DONE'),
--                                                 ('Hacer clases', 'TODO');
SELECT * FROM TAREAS;
update tareas set estado = 'done' where id_tarea = 2;
select * from tareas;