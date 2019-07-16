package comndroid.example.recyclerview.smarteducation.http.helper;


import java.io.File;

import comndroid.example.recyclerview.smarteducation.MyApplication;
import okhttp3.Cache;

/**
 * _ooOoo_
 * o8888888o
 * 88" . "88
 * (| -_- |)
 * O\  =  /O
 * ____/`---'\____
 * .'  \\|     |//  `.
 * /  \\|||  :  |||//  \
 * /  _||||| -:- |||||-  \
 * |   | \\\  -  /// |   |
 * | \_|  ''\---/''  |   |
 * \  .-\__  `-`  ___/-. /
 * ___`. .'  /--.--\  `. . __
 * ."" '<  `.___\_<|>_/___.'  >'"".
 * | | :  `- \`.;`\ _ /`;.`/ - ` : | |
 * \  \ `-.   \_ __\ /__ _/   .-` /  /
 * ======`-.____`-.___\_____/___.-`____.-'======
 * `=---='
 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 * 佛祖保佑        永无BUG
 * 佛曰:
 * 写字楼里写字间，写字间里程序员；
 * 程序人员写程序，又拿程序换酒钱。
 * 酒醒只在网上坐，酒醉还来网下眠；
 * 酒醉酒醒日复日，网上网下年复年。
 * 但愿老死电脑间，不愿鞠躬老板前；
 * 奔驰宝马贵者趣，公交自行程序员。
 * 别人笑我忒疯癫，我笑自己命太贱；
 * 不见满街漂亮妹，哪个归得程序员？
 */
public class CacheHelper {
    private static File cacheFile;
    private static CacheHelper helper;
    private static long maxSize = 50*1024*1024;
    private Cache mCache;

    private CacheHelper()
    {
        cacheFile = new File(MyApplication.getContext().getCacheDir().getAbsolutePath(), "wlgCache");
        if (!cacheFile.exists())
            cacheFile.mkdir();
    }

    public static CacheHelper getInstance() {
        if (helper == null) {
            synchronized (CacheHelper.class) {
                if (helper == null) {
                    helper = new CacheHelper();
                }
            }
        }
        return helper;
    }

    public Cache getCache()
    {
        if (this.mCache == null)
            this.mCache = new Cache(cacheFile, maxSize);
        return this.mCache;
    }
}