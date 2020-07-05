package com.example.mail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@SpringBootTest
class MailApplicationTests {

    @Autowired
    private SendMail sendMail;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    void contextLoads() {
    }

    /**
     * 纯文本邮件测试
     */
    @Test
    void simpleMailSend() {
        String to = "xxx@163.com";
        String subject = "测试邮件发送";
        String content = "SpringBoot 邮件发送";
        sendMail.sendMail(to, subject, content);
    }

    /**
     * 复杂邮件测试
     */
    @Test
    void sendComplxMail() {
        String to = "zhangzhibo1014@163.com";
        String subject = "测试邮件附件发送";
        // 定义邮件内容
        StringBuilder builder = new StringBuilder();
        builder.append("<html><head></head>");
        builder.append("<body><h1>我的头像</h1></body>");
        String rscId = "logo";
        builder.append("<img src='cid:" + rscId + "'/></body>");
        builder.append("</html>");
        // 指定静态资源路径以及附件路径
        String filePath = "C:\\Users\\zhang\\Documents\\makedown\\JavaMail.md";
        String rscPath = "C:\\workspace\\logo.jpg";
        // 发送复杂邮件
        sendMail.sendComplexMail(to, subject, builder.toString(), filePath, rscId, rscPath);

    }

    @Test
    void sendTemplateMail() {
        String to = "zhangzhibo1014@163.com";
        String subject = "测试模板邮件发送";
        // 使用模板邮件定制邮件正文内容
        Context context = new Context();
        context.setVariable("username", "robin");
        context.setVariable("code", 971014);
        // 使用TemplateEngine设置要处理的模板页面
        String emailContent = templateEngine.process("emailTemplate", context);
        // 发送模板邮件
        sendMail.sendTemplateMail(to, subject, emailContent);
    }

}
