import { motion } from "framer-motion";
import bitbybidImg from "../assets/WhatsApp Image 2025-05-02 at 2.14.12 PM.jpeg";
import chatserverImg from "../assets/Screenshot at 15-46-28.png";
import mygameImg from "../assets/1741790685943.png";
import paintImg from "../assets/Screenshot at 16-23-11.png";

const featuredProjects = [
  {
    name: "BitByBid (RFP SPA)",
    description:
      "Smart Java + Spring Boot app that generates automated responses to RFPs using AI. Produces structured PDFs based on good/bad examples.",
    stack: ["Java", "Spring Boot", "PostgreSQL", "HTML", "CSS", "AI", "PDF"],
    image: bitbybidImg,
    github:
      "https://github.com/DiogoCarvalho999/MyProjects/tree/main/BitByBid%20(RFP%20SPA)",
  },
  {
    name: "ChatServer",
    description:
      "Multi-client terminal-based chat server built with Java Sockets. Supports commands like /list, /whisper, and /quit. Great for learning networking and concurrency.",
    stack: ["Java", "TCP Sockets", "Threads", "Netcat"],
    image: chatserverImg,
    github:
      "https://github.com/DiogoCarvalho999/MyProjects/tree/main/ChatServer",
  },
  {
    name: "Save the Chickens (MyGame)",
    description:
      "2D Java game with an original story. Explore rooms, rescue chickens and defeat the evil witch using SimpleGraphics.",
    stack: ["Java", "OOP", "SimpleGraphics"],
    image: mygameImg,
    github: "https://github.com/DiogoCarvalho999/MyProjects/tree/main/MyGame",
  },
  {
    name: "Paint (Grid Painter)",
    description:
      "Interactive tool that allows users to paint grid cells via keyboard. Supports saving and loading .txt drawings.",
    stack: ["Java", "SimpleGraphics", "File I/O"],
    image: paintImg,
    github: "https://github.com/DiogoCarvalho999/MyProjects/tree/main/Paint",
  },
];

const Projects = () => {
  return (
    <motion.div
      initial={{ opacity: 0, y: 10 }}
      animate={{ opacity: 1, y: 0 }}
      exit={{ opacity: 0, y: -10 }}
      transition={{ duration: 0.4 }}
    >
      <section className="pt-24 px-6 transition-colors duration-300">
        <h2 className="text-3xl font-bold text-center text-black dark:text-white mb-10">
          Featured Projects
        </h2>

        <div className="grid gap-8 sm:grid-cols-1 md:grid-cols-2">
          {featuredProjects.map((project, index) => (
            <motion.div
              key={index}
              className="bg-white/90 dark:bg-gray-800 rounded-lg shadow-md p-6 hover:shadow-lg transition"
              initial={{ opacity: 0, y: 20 }}
              whileInView={{ opacity: 1, y: 0 }}
              viewport={{ once: true }}
              transition={{ duration: 0.5 }}
            >
              {project.image && (
                <img
                  src={project.image}
                  alt={project.name}
                  className="w-full h-48 object-cover rounded mb-4"
                />
              )}
              <h3 className="text-xl font-bold text-black dark:text-white mb-2">
                {project.name}
              </h3>
              <p className="text-sm text-black dark:text-gray-100 mb-3">
                {project.description}
              </p>
              <div className="flex flex-wrap gap-2 mb-3">
                {project.stack.map((tech, i) => (
                  <span
                    key={i}
                    className="bg-blue-100 text-blue-800 dark:bg-blue-800 dark:text-blue-100 text-xs px-2 py-1 rounded"
                  >
                    {tech}
                  </span>
                ))}
              </div>
              <a
                href={project.github}
                className="text-blue-600 dark:text-blue-400 underline font-medium"
                target="_blank"
                rel="noreferrer"
              >
                View on GitHub →
              </a>
            </motion.div>
          ))}
        </div>
      </section>
    </motion.div>
  );
};

export default Projects;
