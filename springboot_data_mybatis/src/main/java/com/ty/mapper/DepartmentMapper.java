package com.ty.mapper;

import com.ty.entity.Department;
import org.apache.ibatis.annotations.*;

/**
 * 通过注解法操作数据
 * Created by Administrator on 2018/1/1.
 */
@Mapper
public interface DepartmentMapper {
    /**
     * 通id查询部门
     * @param id
     * @return
     */
    @Select("select * from department where id = #{id}")
    public Department selectOneDeptById(Integer id);

    /**
     * 增加一个部门
     *  @Options:封装自增的主键，以便于前端获取id值
     * @return
     */
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department(department_name) values(#{departmentName})")
    public int insertOneDept(Department department);

    /**
     * 通过id删除一个部门
     * @param id
     * @return
     */
    @Delete("delete from department where id = #{id}")
    public int deleteOneDeptById(Integer id);

    /**
     * 通过id更新一个部门
     * @param department
     * @return
     */
    @Update("update department set departmentName = #{departmentName} where id = #{id}")
    public  int updateOneDeptById(Department department);
}
