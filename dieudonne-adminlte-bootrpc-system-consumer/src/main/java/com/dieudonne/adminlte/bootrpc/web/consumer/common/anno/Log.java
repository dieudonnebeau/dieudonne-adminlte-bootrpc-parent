package com.dieudonne.adminlte.bootrpc.web.consumer.common.anno;

import java.lang.annotation.*;

/**
 * 
 * @ClassName:  Log   
 * @Description:记录业务日志
 * @author: 湖南无为网电子商务有限公司  (Dieudonne)
 * @date:   2018年11月27日 上午10:18:41   
 *     
 * @Copyright: 2018 http://www.0731333.com Inc. All rights reserved. 
 * 注意：本内容仅限于湖南无为网电子商务有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {

	 String value() ;
}
