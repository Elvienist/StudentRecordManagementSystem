    package org.example.studentrecordmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection connect() {
        try {
            return DriverManager.getConnection(
                    "jdbc:postgresql://aws-1-ap-southeast-1.pooler.supabase.com:6543/postgres?sslmode=require&prepareThreshold=0",
                    "postgres.asoskpbdefasqmnsfzmt",
                    "*J%4i.YXznawTFR"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}


