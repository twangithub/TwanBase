package com.twan.base.entity;

import java.util.List;

public class Bean {
    private String error;
    private List<Data> results;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<Data> getResults() {
        return results;
    }

    public void setResults(List<Data> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "error='" + error + '\'' +
                ", results=" + results +
                '}';
    }

    public static class Data {
        private String _id;
        private String en_name;
        private String name;
        private String rank;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getEn_name() {
            return en_name;
        }

        public void setEn_name(String en_name) {
            this.en_name = en_name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRank() {
            return rank;
        }

        public void setRank(String rank) {
            this.rank = rank;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "_id='" + _id + '\'' +
                    ", en_name='" + en_name + '\'' +
                    ", name='" + name + '\'' +
                    ", rank='" + rank + '\'' +
                    '}';
        }
    }
}
