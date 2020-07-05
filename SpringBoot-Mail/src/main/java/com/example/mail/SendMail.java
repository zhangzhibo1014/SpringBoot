package com.example.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 *  发送纯文本邮件
 */
@Service
public class SendMail {

    @Autowired
    private JavaMailSender mailSender;

    // 采用注解注入配置文件中的值
    @Value("${spring.mail.username}")
    private String from;

    /**
     * 发送模板邮件
     * @param to 收件人
     * @param subject 邮件主题
     * @param content 模板邮件内容
     */
    public void sendTemplateMail(String to, String subject, String content) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);

            mailSender.send(message);
            System.out.println("模板邮件发送成功");
        } catch (Exception e) {
            System.out.println("邮件模板发送失败" + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 发送带附件和图片的邮件
     * @param to 收件人
     * @param subject 邮件主题
     * @param content 邮件内容
     * @param filePath 附件路径
     * @param rscId 静态资源文件标识
     * @param rscPath 静态资源文件路径
     */
    public void sendComplexMail(String to, String subject, String content,
                                String filePath, String rscId, String rscPath) {

        // 定制复杂邮件信息 MimeMessage
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);
            // 设置邮件静态资源
            FileSystemResource res = new FileSystemResource(new File(rscPath));
            helper.addInline(rscId, res);
            // 设置邮件附件
            FileSystemResource file = new FileSystemResource(new File(filePath));
            String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
            helper.addAttachment(fileName, file);

            // 发送邮件
            mailSender.send(mimeMessage);
            System.out.println("复杂邮件发送成功");

        } catch (Exception e) {
            System.out.println("复杂邮件发送失败" + e.getMessage());
            e.printStackTrace();
        }
    }


    /**
     * 发送纯文本邮件
     * @param to 收件人
     * @param subject 邮件主题
     * @param content 邮件内容
     */
    public void sendMail(String to, String subject, String content) {
        // 定制纯文本邮件信息 SimpleMailMessage
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        // 发件人
        simpleMailMessage.setFrom(from);
        // 收件人
        simpleMailMessage.setTo(to);
        // 邮件主题
        simpleMailMessage.setSubject(subject);
        // 邮件内容
        simpleMailMessage.setText(content);

        try {
            mailSender.send(simpleMailMessage);
            System.out.println("邮件发送成功");
        }catch (Exception e) {
            System.out.println("邮件发送失败");
            e.printStackTrace();
        }
    }

}
