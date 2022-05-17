package me.jiyong.model.base;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.Timestamp;

/**
 * 通用字段， is_del 根据需求自行添加
 * @author jiyong.me
 * @Date 2020/12/12/
 */
@Getter
@Setter
public class BaseEntity implements Serializable {

    @CreatedBy
    @TableField(value = "created_by")
    @ApiModelProperty(value = "创建人", hidden = true)
    private String createdBy;

    @LastModifiedBy
    @TableField(value = "updated_by")
    @ApiModelProperty(value = "更新人", hidden = true)
    private String updatedBy;

    @TableField(value = "created_time")
    @ApiModelProperty(value = "创建时间", hidden = true)
    private Timestamp createdTime;

    @TableField(value = "updated_time")
    @ApiModelProperty(value = "更新时间", hidden = true)
    private Timestamp updatedTime;

    /* 分组校验 */
    public @interface Create {}

    /* 分组校验 */
    public @interface Update {}

    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this);
        Field[] fields = this.getClass().getDeclaredFields();
        try {
            for (Field f : fields) {
                f.setAccessible(true);
                builder.append(f.getName(), f.get(this)).append("\n");
            }
        } catch (Exception e) {
            builder.append("toString builder encounter an error");
        }
        return builder.toString();
    }
}
