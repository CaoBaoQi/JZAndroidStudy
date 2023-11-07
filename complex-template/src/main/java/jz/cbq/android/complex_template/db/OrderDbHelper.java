package jz.cbq.android.complex_template.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import jz.cbq.android.complex_template.entity.CarInfo;

import java.util.List;


/**
 * OrderDbHelper
 *
 * @author CBQ
 * @date 2023/11/7 21:56
 * @since 1.0.0
 */
public class OrderDbHelper extends SQLiteOpenHelper {
    private static OrderDbHelper sHelper;
    /**
     * 数据库名
     */
    private static final String DB_NAME = "order.db";
    /**
     * 版本号
     */
    private static final int VERSION = 1;

    public OrderDbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /**
     * 创建单例，供使用调用该类里面的的增删改查的方法
     *
     * @param context context
     * @return UserDbHelper
     */
    public synchronized static OrderDbHelper getInstance(Context context) {
        if (null == sHelper) {
            sHelper = new OrderDbHelper(context, DB_NAME, null, VERSION);
        }
        return sHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // 创建 order_table 表
        db.execSQL("create table order_table(order_id integer primary key autoincrement, " +
                "username text," +
                "product_img integer," +
                "product_title text," +
                "product_price integer," +
                "product_count integer," +
                "address text," +
                "mobile text" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    /**
     * 批量插入
     * @param list list
     * @param address address
     * @param mobile mobile
     */
    public void insertByAll(List<CarInfo> list, String address, String mobile) {
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        try {
            for (int i = 0; i < list.size(); i++) {
                ContentValues values = new ContentValues();
                values.put("username", list.get(i).getUsername());
                values.put("product_img", list.get(i).getProduct_img());
                values.put("product_title", list.get(i).getProduct_title());
                values.put("product_price", list.get(i).getProduct_price());
                values.put("product_count", list.get(i).getProduct_count());
                values.put("address", address);
                values.put("mobile", mobile);
                db.insert("order_table", null, values);

            }
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }

        db.close();

    }

}
