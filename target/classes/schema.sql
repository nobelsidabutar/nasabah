create  table if not exists `nasabah`(
                                         nik BIGINT  PRIMARY KEY,
                                         nama VARCHAR(250) NOT NULL,
                                         pendapatan DECIMAL(20,2) NOT NULL,
                                         tanggal_lahir DATE NOT NULL,
                                         career VARCHAR(250) DEFAULT NULL
);
