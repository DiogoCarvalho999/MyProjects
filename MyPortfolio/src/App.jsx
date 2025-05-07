import { Routes, Route, useLocation } from "react-router-dom";
import { AnimatePresence } from "framer-motion";
import NavBar from "./components/NavBar";
import Footer from "./components/Footer";
import Home from "./components/Home";
import About from "./components/About";
import Projects from "./components/Projects";
import Contact from "./components/Contact";
import Background from "./components/Background";
import { useState, useEffect } from "react";

function App() {
  const [darkMode, setDarkMode] = useState(() => {
    const stored = localStorage.getItem("darkMode");
    if (stored !== null) return stored === "true";
    return window.matchMedia("(prefers-color-scheme: dark)").matches;
  });

  useEffect(() => {
    document.documentElement.classList.toggle("dark", darkMode);
    localStorage.setItem("darkMode", darkMode);
  }, [darkMode]);

  const location = useLocation();
  const isHome = location.pathname === "/";

  return (
    <div className="min-h-screen flex flex-col font-sans text-gray-800 dark:text-gray-100">
      <NavBar darkMode={darkMode} setDarkMode={setDarkMode} />
      <Background darkMode={darkMode} />

      <main
        className={`flex-grow pt-20 relative z-10 ${
          isHome ? "overflow-hidden" : "overflow-auto"
        }`}
      >
        <AnimatePresence mode="wait" initial={false}>
          <Routes location={location} key={location.pathname}>
            <Route path="/" element={<Home />} />
            <Route path="/about" element={<About />} />
            <Route path="/projects" element={<Projects />} />
            <Route path="/contact" element={<Contact />} />
          </Routes>
        </AnimatePresence>
      </main>

      <Footer />
    </div>
  );
}

export default App;
