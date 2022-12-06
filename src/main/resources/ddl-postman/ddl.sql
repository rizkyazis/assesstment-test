-- public.produsen definition

-- Drop table

-- DROP TABLE public.produsen;

CREATE TABLE public.produsen (
                                 id serial4 NOT NULL,
                                 nama varchar NULL,
                                 kode varchar NULL,
                                 alamat varchar NULL,
                                 CONSTRAINT produsen_pk PRIMARY KEY (id)
);


-- public.produk definition

-- Drop table

-- DROP TABLE public.produk;

CREATE TABLE public.produk (
                               id serial4 NOT NULL,
                               nama varchar NULL,
                               jenis varchar NULL,
                               berat varchar NULL,
                               produsen_id int4 NOT NULL,
                               CONSTRAINT produk_pk PRIMARY KEY (id)
);


-- public.produk foreign keys

ALTER TABLE public.produk ADD CONSTRAINT produk_fk FOREIGN KEY (produsen_id) REFERENCES public.produsen(id) ON DELETE CASCADE ON UPDATE CASCADE;