import { Link } from "react-router-dom";
import { motion } from "framer-motion";

const Home = () => (
  <motion.div
    initial={{ opacity: 0, y: 10 }}
    animate={{ opacity: 1, y: 0 }}
    exit={{ opacity: 0, y: -10 }}
    transition={{ duration: 0.4 }}
  >
    <section className="flex flex-col justify-center items-center text-center p-6 min-h-[calc(100vh-5rem-4rem)] transition-colors duration-300">
      <motion.div
        className="text-sm uppercase tracking-widest text-blue-500 font-medium mb-2"
        initial={{ scale: 0.95, opacity: 0.7 }}
        whileInView={{ scale: 1, opacity: 1 }}
        animate={{ scale: [0.95, 1, 0.95], opacity: [0.7, 1, 0.7] }}
        transition={{
          duration: 2,
          repeat: Infinity,
          repeatType: "loop",
          ease: "easeInOut",
        }}
        viewport={{ once: true }}
      >
        Welcome to my portfolio
      </motion.div>

      <motion.h1
        className="text-4xl font-bold text-black dark:text-white"
        initial={{ opacity: 0, y: -20 }}
        whileInView={{ opacity: 1, y: 0 }}
        viewport={{ once: true }}
        transition={{ duration: 0.6 }}
      >
        Hi! I'm Diogo Carvalho
      </motion.h1>

      <motion.p
        className="text-lg text-black dark:text-gray-100 mt-4 max-w-md"
        initial={{ opacity: 0, y: 10 }}
        whileInView={{ opacity: 1, y: 0 }}
        viewport={{ once: true }}
        transition={{ delay: 0.2, duration: 0.6 }}
      >
        Versatile full-stack developer passionate about creating clean,
        efficient, and impactful software — from web applications to backend
        systems and beyond.
      </motion.p>

      <div className="mt-6 flex gap-4">
        <Link
          to="/about"
          className="bg-blue-600 text-white px-6 py-2 rounded hover:bg-blue-700 transition"
        >
          Learn more
        </Link>
        <Link
          to="/projects"
          className="border border-blue-600 text-blue-600 px-6 py-2 rounded hover:bg-blue-600 hover:text-white transition"
        >
          View Projects
        </Link>
      </div>
    </section>
  </motion.div>
);

export default Home;
