package me.jiyong.constant;

/**
 * 项目常量
 *
 * @author jiyong.me
 */
public final class ProjectConstant {
    /**
     * 生成代码所在的基础包名称，可根据自己公司的项目修改（注意：这个配置修改之后需要手工修改src目录项目默认的包路径，使其保持一致，不然会找不到类）
     **/
    public static final String BASE_PACKAGE = "me.jiyong";

    /**
     * 生成modules包
     */
    public static final String MODULES_PACKAGE = ".modules";

    /**
     * 生成的Entity所在包
     */
    public static final String ENTITY_PACKAGE = BASE_PACKAGE + ".entity";

    /**
     * 生成的Mapper所在包
     */
    public static final String MAPPER_PACKAGE = BASE_PACKAGE + MODULES_PACKAGE + ".*" + ".mapper";

    /**
     * 生成的Service所在包
     */
    public static final String SERVICE_PACKAGE = BASE_PACKAGE + MODULES_PACKAGE;

    /**
     * 生成的ServiceImpl所在包
     */
    public static final String SERVICE_IMPL_PACKAGE = SERVICE_PACKAGE + ".impl";

    /**
     * 生成的Controller所在包
     */
    public static final String CONTROLLER_PACKAGE = BASE_PACKAGE + MODULES_PACKAGE;

    /**
     * 生成的Tester所在包
     */
    public static final String TESTER_PACKAGE = ".src.test.java."+BASE_PACKAGE;

}
