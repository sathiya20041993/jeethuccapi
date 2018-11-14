package com.app.coacingcenter;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.util.StringUtils;

import com.app.coacingcenter.entity.Course;
import com.app.coacingcenter.entity.Student;
import com.app.coacingcenter.entity.StudentCourse;
import com.app.coacingcenter.repository.StudentCourseRepository;
import com.app.coacingcenter.utils.CustomMailSender;
import com.app.coacingcenter.utils.DateTimeUtil;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

@Component
public class ScheduledJobs {

	@Autowired
	StudentCourseRepository studentCourseRepository;

	@Autowired
	private Configuration freemarkerConfig;

	private static final Logger LOG = LoggerFactory.getLogger(ScheduledJobs.class);

	@Scheduled(cron = "0 0 9 * * ?")
	public void sendEbookdownLoadLink() throws TemplateNotFoundException, MalformedTemplateNameException,
			ParseException, IOException, TemplateException {

		System.out.println("CAme here");
		Date startDate = new Date();
		// Date dateBeforeThreeDays = DateTimeUtil.subtractDays(startDate, 3);

		Date dateBeforeThreeDays = new Date();

		Date beginingOftheDay = DateTimeUtil.appendStartTime(dateBeforeThreeDays);

		Date endOftheDay = DateTimeUtil.appendEndTime(dateBeforeThreeDays);

		List<StudentCourse> studentCourses = studentCourseRepository
				.findAllByRegisteredDateGreaterThanEqualAndRegisteredDateLessThanEqual(beginingOftheDay, endOftheDay);

		for (StudentCourse studentCourse : studentCourses) {

			Student student = studentCourse.getStudent();
			String emailId = student.getEmail();

			if (StringUtils.hasText(emailId)) {

				Course course = studentCourse.getCourse();

				Template t = freemarkerConfig.getTemplate("ebook-link-email.ftl");

				Map<String, Object> model = new HashMap<>();
				model.put("name", student.getStudentName());
				model.put("courseId", course.getCourseId());

				String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);

				CustomMailSender.sendEmail(emailId, "Ebook For " + course.getCourseName(), html);

			}

		}
	}

	@Scheduled(cron = "0 0 0/1 * * ?")
	public void Backupdbtosql() {
		try {

			/* NOTE: Getting path to the Jar file being executed */
			/* NOTE: YourImplementingClass-> replace with the class executing the code */
			// CodeSource codeSource =
			// YourImplementingClass.class.getProtectionDomain().getCodeSource();
			// File jarFile = new File(codeSource.getLocation().toURI().getPath());
			// String jarDir = jarFile.getParentFile().getPath();

			/* NOTE: Creating Database Constraints */
			String dbName = "coachingcenter";
			String dbUser = "root";
			String dbPass = "root";

			/* NOTE: Creating Path Constraints for folder saving */
			/* NOTE: Here the backup folder is created for saving inside it */

			String folderPath = "D:\\backup";

			/* NOTE: Creating Folder if it does not exist */
			File f1 = new File(folderPath);
			f1.mkdir();

			/* NOTE: Creating Path Constraints for backup saving */
			/*
			 * NOTE: Here the backup is saved in a folder called backup with the name
			 * backup.sql
			 */

			/* NOTE: Used to create a cmd command */
			// String executeCmd = savePath + " mysqldump -u " + dbUser + " -p" + dbPass + "
			// --database " + dbName + " -r "
			// + "backup.sql\"";

			String executeCmd = "C:\\Program Files (x86)\\MySQL\\MySQL Server 5.5\\bin\\mysqldump -u" + dbUser + " -p"
					+ dbPass + " --database " + dbName + " -r D:\\backup\\backup.sql";
			System.out.println(executeCmd);

			/* NOTE: Executing the command here */
			Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
			int processComplete = runtimeProcess.waitFor();

			/*
			 * NOTE: processComplete=0 if correctly executed, will contain other values if
			 * not
			 */
			if (processComplete == 0) {
				System.out.println("Backup Complete");
			} else {
				System.out.println("Backup Failure");
			}

		} catch (IOException | InterruptedException ex) {
			JOptionPane.showMessageDialog(null, "Error at Backuprestore" + ex.getMessage());
		}
	}

}
