package com.Perimetr.Perimetr.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Orders {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        private String name, andres, num, dat, full_text;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAndres() {
            return andres;
        }

        public void setAndres(String andres) {
            this.andres = andres;
        }

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
        }

        public String getDat() {
            return dat;
        }

        public void setDat(String dat) {
            this.dat = dat;
        }

        public String getFull_text() {
            return full_text;
        }

        public void setFull_text(String full_text) {
            this.full_text = full_text;
        }

        public Orders()
        {

        }

        public Orders(String name, String andres, String num, String dat, String full_text) {
            this.name = name;
            this.andres = andres;
            this.num = num;
            this.dat = dat;
            this.full_text = full_text;
        }
    }

