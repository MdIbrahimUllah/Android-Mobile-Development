package com.example.tutor_hiring_app.database;

public class TutorAppDbSchema {

    //Parent Table  //tutor Table   //child Table
    public static final class Table{
        public static final String PARENT_TABLE = "parent"; //Using table by: Table.PARENT_TABLE
        public static final String TUTOR_TABLE = "tutor"; //Using table by: Table.TUTOR_TABLE
        public static final String CHILD_TABLE = "child"; //Using table by: Table.CHILD_TABLE

        public static final class Cols{
            public static final String F_NAME = "f_name"; //Using columns name by: Table.Cols.F_NAME
            public static final String L_NAME = "l_name";
            public static final String CIVIC_NUMBER = "civic_number";
            public static final String STREET_NAME = "street_name";
            public static final String APP_NUMBER = "app_number";
            public static final String CITY_NAME = "city_name";
            public static final String PROVINCE_NAME = "province_name";
            public static final String POSTAL_CODE = "postal_code";
            public static final String COUNTRY_NAME = "country_name";
            public static final String TEL_NUMBER = "tel_number";

            public static final String SUBJ_NAME = "subj_name";
            public static final String HOUR_FEES = "hour_fees";
            public static final String EXPERIENCE = "experience";

            public static final String CHILD_F_NAME = "child_f_name"; //Using columns name by: Table.Cols.CHILD_F_NAME
            public static final String CHILD_L_NAME = "child_l_name";
            public static final String CHILD_AGE = "child_age";
        }
    }
}
