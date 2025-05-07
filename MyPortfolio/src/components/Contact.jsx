import { useState } from "react";
import { motion } from "framer-motion";
import emailjs from "@emailjs/browser";

const Contact = () => {
  const [formData, setFormData] = useState({
    name: "",
    email: "",
    message: "",
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prev) => ({ ...prev, [name]: value }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    emailjs
      .send(
        "service_4hitcp9",
        "template_z642ydk",
        formData,
        "APP-1V1jGJyM4cwmo"
      )
      .then(() => {
        alert("Message sent successfully!");
        setFormData({ name: "", email: "", message: "" });
      })
      .catch((error) => {
        console.error("Error sending email:", error);
        alert("Failed to send message. Please try again.");
      });
  };

  return (
    <motion.div
      initial={{ opacity: 0, y: 10 }}
      animate={{ opacity: 1, y: 0 }}
      exit={{ opacity: 0, y: -10 }}
      transition={{ duration: 0.4 }}
    >
      <section className="pt-24 px-6 transition-colors duration-300 text-black dark:text-white">
        <h2 className="text-3xl font-bold text-center mb-4">Contact</h2>

        <p className="text-center text-gray-600 dark:text-gray-300 mb-10 max-w-2xl mx-auto">
          Whether you have a question, a project idea, or just want to connect —
          feel free to reach out!
        </p>

        <div className="grid md:grid-cols-2 gap-12 max-w-5xl mx-auto">
          {/* Contact info */}
          <div className="space-y-4">
            <div>
              <p className="text-lg font-semibold">Email</p>
              <a
                href="mailto:diogodias0001@hotmail.com"
                className="text-blue-600 dark:text-blue-400 underline"
              >
                diogodias0001@hotmail.com
              </a>
            </div>
            <div>
              <p className="text-lg font-semibold">LinkedIn</p>
              <a
                href="https://www.linkedin.com/in/diogoadcarvalho/"
                target="_blank"
                rel="noreferrer"
                className="text-blue-600 dark:text-blue-400 underline"
              >
                diogoadcarvalho
              </a>
            </div>
            <div>
              <p className="text-lg font-semibold">GitHub</p>
              <a
                href="https://github.com/DiogoCarvalho999"
                target="_blank"
                rel="noreferrer"
                className="text-blue-600 dark:text-blue-400 underline"
              >
                DiogoCarvalho999
              </a>
            </div>
          </div>

          {/* Contact form */}
          <form onSubmit={handleSubmit} className="space-y-4">
            <input
              type="text"
              name="name"
              placeholder="Your name"
              value={formData.name}
              onChange={handleChange}
              required
              className="w-full p-3 border border-gray-300 dark:border-gray-700 rounded bg-white dark:bg-gray-800 text-black dark:text-white focus:outline-none focus:ring-2 focus:ring-blue-500"
            />
            <input
              type="email"
              name="email"
              placeholder="Your email"
              value={formData.email}
              onChange={handleChange}
              required
              className="w-full p-3 border border-gray-300 dark:border-gray-700 rounded bg-white dark:bg-gray-800 text-black dark:text-white focus:outline-none focus:ring-2 focus:ring-blue-500"
            />
            <textarea
              name="message"
              placeholder="Your message"
              rows="5"
              value={formData.message}
              onChange={handleChange}
              required
              className="w-full p-3 border border-gray-300 dark:border-gray-700 rounded bg-white dark:bg-gray-800 text-black dark:text-white focus:outline-none focus:ring-2 focus:ring-blue-500"
            />
            <button
              type="submit"
              className="bg-blue-600 text-white px-6 py-3 rounded hover:bg-blue-700 transition"
            >
              Send Message
            </button>
          </form>
        </div>
      </section>
    </motion.div>
  );
};

export default Contact;
