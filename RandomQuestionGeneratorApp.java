package LangDemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

    public class RandomQuestionGeneratorApp extends JFrame {
        private String[] questions = {
                "What is the capital of India?",
                "What is the largest planet in our solar system?",
                "Who wrote 'Romeo and Juliet'?",
                "What is the chemical symbol for water?",
                "Who painted the Mona Lisa?"
        };

        private JLabel questionLabel;
        private JButton generateButton;

        public RandomQuestionGeneratorApp() {
            setTitle("Random Question Generator");
            setSize(400, 200);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);

            initComponents();
        }

        private void initComponents() {
            questionLabel = new JLabel("Press 'Generate' to get a random question", JLabel.CENTER);
            questionLabel.setFont(new Font("Arial", Font.PLAIN, 16));

            generateButton = new JButton("Generate");
            generateButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String randomQuestion = generateRandomQuestion();
                    questionLabel.setText(randomQuestion);
                }
            });

            JPanel mainPanel = new JPanel(new BorderLayout());
            mainPanel.add(questionLabel, BorderLayout.CENTER);
            mainPanel.add(generateButton, BorderLayout.SOUTH);

            add(mainPanel);
        }

        private String generateRandomQuestion() {
            Random rand = new Random();
            int index = rand.nextInt(questions.length);
            return questions[index];
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    RandomQuestionGeneratorApp app = new RandomQuestionGeneratorApp();
                    app.setVisible(true);
                }
            });
        }
    }


