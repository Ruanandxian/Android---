package blcs.lwb.utils.greendao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.example.myapplication.entertainment;
import com.example.myapplication.information;
import com.example.myapplication.life;
import com.example.myapplication.shopping;
import com.example.myapplication.test;

import blcs.lwb.utils.greendao.entertainmentDao;
import blcs.lwb.utils.greendao.informationDao;
import blcs.lwb.utils.greendao.lifeDao;
import blcs.lwb.utils.greendao.shoppingDao;
import blcs.lwb.utils.greendao.testDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig entertainmentDaoConfig;
    private final DaoConfig informationDaoConfig;
    private final DaoConfig lifeDaoConfig;
    private final DaoConfig shoppingDaoConfig;
    private final DaoConfig testDaoConfig;

    private final entertainmentDao entertainmentDao;
    private final informationDao informationDao;
    private final lifeDao lifeDao;
    private final shoppingDao shoppingDao;
    private final testDao testDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        entertainmentDaoConfig = daoConfigMap.get(entertainmentDao.class).clone();
        entertainmentDaoConfig.initIdentityScope(type);

        informationDaoConfig = daoConfigMap.get(informationDao.class).clone();
        informationDaoConfig.initIdentityScope(type);

        lifeDaoConfig = daoConfigMap.get(lifeDao.class).clone();
        lifeDaoConfig.initIdentityScope(type);

        shoppingDaoConfig = daoConfigMap.get(shoppingDao.class).clone();
        shoppingDaoConfig.initIdentityScope(type);

        testDaoConfig = daoConfigMap.get(testDao.class).clone();
        testDaoConfig.initIdentityScope(type);

        entertainmentDao = new entertainmentDao(entertainmentDaoConfig, this);
        informationDao = new informationDao(informationDaoConfig, this);
        lifeDao = new lifeDao(lifeDaoConfig, this);
        shoppingDao = new shoppingDao(shoppingDaoConfig, this);
        testDao = new testDao(testDaoConfig, this);

        registerDao(entertainment.class, entertainmentDao);
        registerDao(information.class, informationDao);
        registerDao(life.class, lifeDao);
        registerDao(shopping.class, shoppingDao);
        registerDao(test.class, testDao);
    }
    
    public void clear() {
        entertainmentDaoConfig.clearIdentityScope();
        informationDaoConfig.clearIdentityScope();
        lifeDaoConfig.clearIdentityScope();
        shoppingDaoConfig.clearIdentityScope();
        testDaoConfig.clearIdentityScope();
    }

    public entertainmentDao getEntertainmentDao() {
        return entertainmentDao;
    }

    public informationDao getInformationDao() {
        return informationDao;
    }

    public lifeDao getLifeDao() {
        return lifeDao;
    }

    public shoppingDao getShoppingDao() {
        return shoppingDao;
    }

    public testDao getTestDao() {
        return testDao;
    }

}
