package me.jiyong.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import me.jiyong.utils.SecurityUtils;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * some words
 *
 * @author jiyong.me
 * @date 2021/11/1
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    private static final String CREATED_BY = "createdBy";
    private static final String UPDATED_BY = "updatedBy";

    private static final String CREATED_TIME = "createdTime";
    private static final String UPDATED_TIME = "updatedTime";

    private static final String DEPT_ID = "deptId";
    private static final String USER_ID = "userId";

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");

        //时间
        if (metaObject.hasGetter(CREATED_TIME)) {
            this.fillStrategy(metaObject, CREATED_TIME, LocalDateTime.now());
        }

        if (metaObject.hasGetter(UPDATED_TIME)) {
            this.fillStrategy(metaObject, UPDATED_TIME, LocalDateTime.now());
        }

        if(metaObject.hasGetter(CREATED_BY)) {
            this.fillStrategy(metaObject, CREATED_BY, SecurityUtils.getCurrentUsername());
        }

        if(metaObject.hasGetter(UPDATED_BY)) {
            this.fillStrategy(metaObject, UPDATED_BY, SecurityUtils.getCurrentUsername());
        }

        if(metaObject.hasGetter(DEPT_ID)) {
            this.fillStrategy(metaObject, DEPT_ID, SecurityUtils.getDeptId());
        }

        if(metaObject.hasGetter(USER_ID)) {
            this.fillStrategy(metaObject, USER_ID, SecurityUtils.getCurrentUserId());
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");

        //时间
        if (metaObject.hasGetter(UPDATED_TIME)) {
            this.fillStrategy(metaObject, UPDATED_TIME, LocalDateTime.now());
        }

        //用户
        if(metaObject.hasGetter(UPDATED_BY)) {
            this.fillStrategy(metaObject, UPDATED_BY, SecurityUtils.getCurrentUsername());
        }
    }
}
