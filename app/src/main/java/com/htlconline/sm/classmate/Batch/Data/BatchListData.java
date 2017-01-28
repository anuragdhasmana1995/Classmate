package com.htlconline.sm.classmate.Batch.Data;

import java.util.List;

/**
 * Created by Anurag on 26-12-2016.
 */

public class BatchListData {

    private int count;
    private int total_pages;
    private List<Results> results;
    private String next;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }


    public class Results {

        private int id;
        private String centre;
        private String academic_year;
        private String display_name;
        private String subject;
        private String start_date;
        private Attendance get_attendance_percentage;

        public String getCentre() {
            return centre;
        }

        public void setCentre(String centre) {
            this.centre = centre;
        }

        public String getStart_date() {
            return start_date;
        }

        public void setStart_date(String start_date) {
            this.start_date = start_date;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Attendance getGet_attendence_percentage() {
            return get_attendance_percentage;
        }

        public void setGet_attendence_percentage(Attendance get_attendence_percentage) {
            this.get_attendance_percentage = get_attendence_percentage;
        }

        public String getDisplay_name() {
            return display_name;
        }

        public void setDisplay_name(String display_name) {
            this.display_name = display_name;
        }

        public String getAcademic_year() {
            return academic_year;
        }

        public void setAcademic_year(String academic_year) {
            this.academic_year = academic_year;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }
    }


    public class Attendance {

        private int absent;

        public int getAbsent() {
            return absent;
        }

        public void setAbsent(int absent) {
            this.absent = absent;
        }
    }


}
