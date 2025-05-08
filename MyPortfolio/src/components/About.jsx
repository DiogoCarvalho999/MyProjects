import React from "react";
import { motion } from "framer-motion";
import myPhoto from "../assets/1741775474382.jpeg";

const About = () => {
  return (
    <motion.div
      initial={{ opacity: 0, y: 10 }}
      animate={{ opacity: 1, y: 0 }}
      exit={{ opacity: 0, y: -10 }}
      transition={{ duration: 0.4 }}
    >
      <section className="bg-transparent py-16 px-4 md:px-10 lg:px-20 text-black dark:text-white backdrop-blur-sm">
        <div className="max-w-6xl mx-auto flex flex-col md:flex-row items-center gap-10">
          {/* Imagem */}
          <div className="flex-shrink-0 w-64 h-64 overflow-hidden rounded-full shadow-lg">
            <img
              src={myPhoto}
              alt="Diogo Carvalho"
              className="w-full h-full object-cover"
            />
          </div>

          {/* Texto */}
          <div className="text-center md:text-left">
            <h2 className="text-3xl font-bold text-blue-600 mb-4">About Me</h2>
            <p className="text-lg text-gray-800 dark:text-gray-200 max-w-xl">
              I'm a junior full-stack developer with a strong passion for
              programming and problem solving. While I'm experienced in both
              frontend and backend development, I particularly enjoy building
              backend logic and integrating AI into meaningful solutions. Beyond
              web applications, I’ve also developed desktop tools,
              terminal-based systems, and interactive games — always seeking to
              turn ideas into working software.
            </p>

            {/* Motivational quote */}
            <p className="italic text-gray-600 dark:text-gray-400 mt-4">
              “Code isn’t just about syntax — it’s about transforming ideas into
              impact.”
            </p>

            {/* Location / Language */}
            <p className="text-sm text-gray-500 mt-2">
              Based in Porto, Portugal · Fluent in English & Portuguese
            </p>

            {/* Skills grid */}
            <h3 className="text-xl font-semibold mt-8 mb-3">Skills</h3>
            <div className="grid grid-cols-2 sm:grid-cols-3 lg:grid-cols-4 gap-3 text-sm text-gray-800 dark:text-gray-200">
              <span>Java</span>
              <span>Spring Boot</span>
              <span>React.js</span>
              <span>PostgreSQL</span>
              <span>Tailwind CSS</span>
              <span>HTML/CSS/JS</span>
              <span>AI Tools</span>
              <span>REST API</span>
              <span>OOP / MVC</span>
              <span>Git & GitHub</span>
              <span>JUnit / Testing</span>
              <span>AWS & Vercel</span>
              <span>SQL</span>
              <span>Scrum / Agile</span>
              <span>Tomcat / Maven</span>
              <span>Bootstrap / jQuery</span>
            </div>
          </div>
        </div>
      </section>
    </motion.div>
  );
};

export default About;
