import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
public class JavaMailDemo {

    // 发件人的 邮箱 和 密码（替换为自己的邮箱和密码）
    // PS: 某些邮箱服务器为了增加邮箱本身密码的安全性，给 SMTP 客户端设置了独立密码（有的邮箱称为“授权码”）,
    //     对于开启了独立密码的邮箱, 这里的邮箱密码必需使用这个独立密码（授权码）。
    public static String myEmailAccount = "xxxxxxxxx@163.com";
    public static String myEmailPassword = "xxxxxxxxx";

    // 发件人邮箱的 SMTP 服务器地址, 必须准确, 不同邮件服务器地址不同, 一般(只是一般, 绝非绝对)格式为: smtp.xxx.com
    // 网易163邮箱的 SMTP 服务器地址为: smtp.163.com
    public static String myEmailSMTPHost = "smtp.163.com";

    // 收件人邮箱（替换为自己知道的有效邮箱）
    public static String receiveMailAccount = "xxxxxxxxx@qq.com";

    public static void main(String []args){


//        flvmfvdoborlbcci




        Properties props = new Properties();                // 用于连接邮件服务器的参数配置（发送邮件时才需要用到）
        Session session= Session.getInstance(props);        // 根据参数配置，创建会话对象（为了发送邮件准备的）
        MimeMessage message = new MimeMessage(session);     // 创建邮件对象
        // 2. From: 发件人
        //    其中 InternetAddress 的三个参数分别为: 邮箱, 显示的昵称(只用于显示, 没有特别的要求), 昵称的字符集编码
        //    真正要发送时, 邮箱必须是真实有效的邮箱。
        try {
            message.setFrom(new InternetAddress("656420514@send.com", "USER_AA", "UTF-8"));
            // 3. To: 收件人
            message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress("656420514@qq.com", "USER_CC", "UTF-8"));
            //    To: 增加收件人（可选）
//            message.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress("dd@receive.com", "USER_DD", "UTF-8"));
            //    Cc: 抄送（可选）
//            message.setRecipient(MimeMessage.RecipientType.CC, new InternetAddress("ee@receive.com", "USER_EE", "UTF-8"));
            //    Bcc: 密送（可选）
//            message.setRecipient(MimeMessage.RecipientType.BCC, new InternetAddress("ff@receive.com", "USER_FF", "UTF-8"));

            // 4. Subject: 邮件主题
            message.setSubject("TEST邮件主题", "UTF-8");

            // 5. Content: 邮件正文（可以使用html标签）
            message.setContent("TEST这是邮件正文。。。", "text/html;charset=UTF-8");

            // 6. 设置显示的发件时间
            message.setSentDate(new Date());

            // 7. 保存前面的设置
            message.saveChanges();

        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }

}
