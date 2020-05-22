package com.commons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Create by gc on 2020/5/22
 * 铁甲依然在
 * 邮件工具类
 */
@Component
public class MailUtil {

    @Autowired
    JavaMailSender javaMailSender;

    public void sendMail(String title,String content,String location) throws Exception {
        // 创建邮件对象
        MimeMessage mMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mMessageHelper=new MimeMessageHelper(mMessage, true, "UTF-8");;
        Properties prop = new Properties();
        prop.load(this.getClass().getResourceAsStream("/config.properties"));
        // 设置发件人邮箱
        mMessageHelper.setFrom(prop.getProperty("mail.smtp.username"));
        // 设置收件人邮箱
        mMessageHelper.setTo(location);
        // 设置邮件的主题也就是邮件的标题
        mMessageHelper.setSubject(title);
        // 设置邮件内容
        mMessageHelper.setText(content);
        javaMailSender.send(mMessage);// 发送邮件
    }

}
