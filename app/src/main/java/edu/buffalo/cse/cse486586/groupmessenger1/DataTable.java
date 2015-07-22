package edu.buffalo.cse.cse486586.groupmessenger1;

import android.provider.BaseColumns;

/**
 * Created by chandana on 2/18/15.
 */
public class DataTable {

public DataTable()
{

}

    public static abstract class TableInfo implements BaseColumns
    {
        public static final String key="key";
        public static final String value="value";
        public static final String DATABASE_NAME="GroupMessenger";
        public static final String TABLE_NAME="Messeges";

    }

}
