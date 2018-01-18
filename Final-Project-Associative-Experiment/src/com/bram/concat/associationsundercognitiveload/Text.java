package com.bram.concat.associationsundercognitiveload;

import java.awt.Font;
import java.util.Calendar;

/**
 * Helper class that contains text displayed in the instructions and in the goodbye message, font settings, datafile headers, ...
 * All text that is displayed to the participant is written here, so if you wish to translate the experiment, you should only need this file.
 */
public abstract class Text {
	
	/**
	 * Label for the ID form entry.
	 */
	public static final String FORM_ID = "№ участника: ";
	
	/**
	 * Label for the age form entry.
	 */
	public static final String FORM_AGE = "Возраст: ";
	
	/**
	 * Label for the gender form entry.
	 */
	public static final String FORM_GENDER = "Пол: ";
	
	/**
	 * Label for the 'male' radiobutton.
	 */
	public static final String FORM_MALE = "Муж";
	
	/**
	 * Label for the 'female' radiobutton.
	 */
	public static final String FORM_FEMALE = "Жен";
	
	/**
	 * Error displayed when user's ID is not valid.
	 */
	public static final String FORM_ERROR_ID = "Пожалуйста, введите свой номер корректно! (Разрешено вводить только цифры)";
	
	/**
	 * Error displayed when user's age is not valid.
	 */
	public static final String FORM_ERROR_AGE = "Пожалуйста, введите свой возраст корректно! (Разрешено вводить только цифры)";
	
	/**
	 * Error displayed when user's gender is not valid.
	 */
	public static final String FORM_ERROR_GENDER = "Вы не указали свой пол. Пожалуйста, попробуйте еще раз.";
	
	
	/**
	 * Label for the button the participant uses to indicate he/she is ready to progress to the next screen.
	 */
	public static final String BTN_READY = "ОК";
	
	/**
	 * Label for the button the participant uses to indicate he/she is ready to begin the experiment.
	 */
	public static final String BTN_BEGIN = "Начать";
	
	/**
	 * Label for the button the participant uses to indicate he/she is ready to progress to the next screen.
	 */
	public static final String BTN_CONTINUE = "Продолжить";
	
	/**
	 * Label for the button the participant uses to go to the previous instructions screen.
	 */
	public static final String BTN_PREVIOUS = "Назад";
	
	/**
	 * Label for the button the participant uses to go to the next instructions screen.
	 */
	public static final String BTN_NEXT = "Вперед";
	
	/**
	 * Label for the button the participant uses to quit the program (at the end).
	 */
	public static final String BTN_QUIT = "Закрыть";
	
	/**
	 * Label for the button the participant uses to indicate he/she does not know the cue word.
	 */
	public static final String BTN_UNKNOWN_CUE = "Неизвестное слово";
	
	/**
	 * Label for the button the participant uses to indicate he/she does not have any further associations to the cue word.
	 */
	public static final String BTN_NO_FURTHER_RESPONSES = "Нет ассоциаций";
	
	/**
	 * Title of the program (in your OS).
	 */
	public static final String TEXT_WINDOW_TITLE = "Лингвистический ассоциативный эксперимент";
	
	/**
	 * Message that is displayed when participant responds too slowly.
	 */
	public static final String TEXT_TOO_SLOW = "Медленно!";
	
	/**
	 * Displayed at the beginning of the experiment, after having asked the ss information. After this, the training phase starts.
	 * Each String is displayed as a separate screen.
	 * Uses HTML formatting.
	 */
	public static final String[] TEXT_INSTRUCTIONS = {  
		"Добро пожаловать в приложение «Лингвистический ассоциативный эксперимент»."+

		""
		+ ""
		+ "<br><br>Вам необходимо дать ассоциацию для определенного слова. Ввести эту ассоциацию нужно в пустое поле, расположенное под этим словом. "
		+ "Предполагается, что Вы пишете в этом поле ассоциацию, которая первой приходит на ум, когда Вы читаете это слово. Для ввода ассоциации используйте клавиатуру."
		+ "<br><br>Важно: Вы должны давать ассоциацию только для текущего слова (не на основе предыдущего ответа). Старайтесь избегать использования предложений. "
		+ "В случае, если если Вы не знаете слова, нажмите кнопку «Неизвестное слово» в нижнем правом углу. ",

		"Для корректного результата желательно, чтобы Вы давали максимально <b>быстрый</b> ответ. "
		+ "Если Вы слишком долго будете ждать, появится сообщение «Медленно!»."
		};

	
	/**
	 * Displayed after the training phase, and before the actual experiment.
	 */
	public static final String TEXT_POSTTRAINING_INSTRUCTIONS =
			"Сейчас мы начнем тестовый эсперимент. Если у вас остались какие-либо вопросы, позовите куратора эксперимента.";
		
	/**
	 * Displayed between two blocks, but not before the last block.
	 */
	public static final String TEXT_INTERBLOCK = "Теперь вы можете остановиться. Нажмите «Готово», если вы хотите начать следующую часть. ";
	
	/**
	 * Displayed before the last block.
	 */
	public static final String TEXT_INTERBLOCK_LAST = "Теперь вы можете остановиться. Нажмите «Готово», если вы хотите запустить последнюю часть. ";
		
	/**
	 * Displayed at the end of the experiment.
	 * Uses HTML formatting.
	 */
	public static final String TEXT_XP_OVER_MESSAGE = 
			"<br><br><br><br>Эксперимент закончился. " +
			"<br><br>Благодарим за участие! " +
			"<br><br>Теперь вы можете закрыть программу. ";

	/**
	 * Output headers i.e. first line of every datafile.
	 */
	public static final String HEADER = "trialNb\tgroupNb\tindexInGroup\tcue\tassociation\tassoNb\ttimeToFirstKeypress\ttimeToSubmission\tlist\t"
			+ "load\toriginal_pattern\treproduced_pattern\tcorrect\thits\tmisses\tfalseAlarms";
	
	
	/**
	 * Font used in all instruction screens and in the goodbye screen.
	 */
	public static final Font FONT_INSTRUCTIONS = new Font("Serif", Font.PLAIN, 26);
	
	/**
	 * The cue is displayed in this font.
	 */
	public static final Font FONT_CUE = new Font("Serif", Font.PLAIN, 50);
	
	/**
	 * The previous associations of this participant to the current cue are displayed in this font.
	 */
	public static final Font FONT_PREVIOUS_RESPONSES = new Font("Serif", Font.PLAIN, 30);
	
	/**
	 * The text-field in which the participant gives association is formatted in this font.
	 */
	public static final Font FONT_ANSWER_TEXTFIELD = new Font("Serif", Font.PLAIN, 40);
	
	/**
	 * The errormessage when participant is too slow is displayed in this font.
	 */
	public static final Font FONT_TOO_SLOW_MESSAGE = new Font("Serif", Font.PLAIN, 60);
		
	/**
	 * @return The current month and day, formatted as a string, separated by an underscore.
	 */
	public static String getDate() {
		Calendar cal = Calendar.getInstance();
		String month = String.valueOf(cal.get(Calendar.MONTH) + 1);	
		String day = String.valueOf(cal.get(Calendar.DATE));
		return month + "_" + day;
	}
	
	/**
	 * @return The current time, formatted as a string, seperated by an underscore.
	 */
	public static String getTime() {	
		Calendar cal = Calendar.getInstance();
		
		String hour = String.valueOf(cal.get(Calendar.HOUR_OF_DAY));
		if (hour.length() == 1) {
			hour = "0" + hour; //pad with zero for 0..9
		}
		
		String min = String.valueOf(cal.get(Calendar.MINUTE));
		if (min.length() == 1) {
			min = "0" + min; //pad with zero for 0..9
		}
		
		String sec = String.valueOf(cal.get(Calendar.SECOND));
		if (sec.length() == 1) {
			sec = "0" + sec; //pad with zero for 0..9
		}
		
		return hour + "_" + min + "_" + sec;	
	}
}