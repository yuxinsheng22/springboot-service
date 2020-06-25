package com.madhouse.es.join;

import com.madhouse.es.join.model.EsClass;
import com.madhouse.es.join.model.EsInfo;
import com.madhouse.es.join.model.EsStudent;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020-04-15 14:36
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EsClassStudentTest {

    @Autowired
    private EsClassStudentService classStudentService;

    @Test
    public void deleteDoc() {
        String id = "u0GYfHEBjr31aFOPbg1d";
        this.classStudentService.deleteDoc(id);
    }

    @Test
    public void addClass() {
        String id = "C-06";
        EsClass esClass = new EsClass("C-06", "高三06班", "中等班级", new EsInfo("class"));
        this.classStudentService.addClass(esClass, id);
    }

    @Test
    public void addStudent() {
        String id = "C-04-S-01";
        String routing = id;
        EsStudent student = new EsStudent("C-04-S-01", "小海", "小海也喜欢游戏", "LOL", new EsInfo("student", "C-04"));
        this.classStudentService.addStudent(student, id, routing);
    }

    @Test
    public void addBatchStudent() throws Exception {
        EsInfo info = new EsInfo("student", "C-04");
        EsStudent student = new EsStudent("C-04-S-01", "C-04-S-01", "小海", "小海酷爱CF", "CF", info);
        EsStudent student1 = new EsStudent("C-04-S-02", "C-04-S-02", "小天", "小海酷爱LOL", "LOL", info);
        this.classStudentService.addBatchStudent(Lists.newArrayList(student, student1));
    }

    @Test
    public void updateClass() {
        String id = "7EGvfHEBjr31aFOPqQ5c";
        this.classStudentService.updateClass(id);
    }

    @Test
    public void findStudentById() {
        String id = "C-04-S-01";
        this.classStudentService.findById(id);
    }

    @Test
    public void findStudentNo() {
        String studentNo = "C-04-S-01";
        this.classStudentService.findByStudentNo(studentNo);
    }

    @Test
    public void updateStudent() {
        String id = "C-04-S-01";
        String studentDesc = "小海酷爱游戏";
        String studentInterest = "CF";
        this.classStudentService.updateStudent(id, studentDesc, studentInterest);
    }


}
