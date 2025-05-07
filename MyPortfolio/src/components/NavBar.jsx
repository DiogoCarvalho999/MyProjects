import { Link } from 'react-router-dom';
import { useState } from 'react';
import { Menu, X, Instagram, Linkedin, Github } from 'lucide-react';

const NavBar = ({ darkMode, setDarkMode }) => {
  const [mobileOpen, setMobileOpen] = useState(false);

  const spotifyIcon = (
    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" viewBox="0 0 24 24">
      <path d="M12 0C5.373 0 .001 5.373.001 12c0 6.627 5.372 12 11.999 12 6.627 0 12-5.373 12-12 .001-6.627-5.372-12-11.999-12zM17.3 17.473c-.205.34-.637.447-.977.243-2.677-1.618-6.054-1.98-10.04-1.078-.39.09-.78-.16-.87-.55-.09-.39.16-.78.55-.87 4.41-.993 8.26-.587 11.262 1.247.34.204.446.637.243.978zm1.404-2.805c-.26.422-.81.553-1.232.292-3.07-1.895-7.748-2.446-11.366-1.33-.473.145-.98-.11-1.124-.58-.146-.47.108-.98.58-1.124 4.13-1.27 9.338-.645 12.863 1.578.423.26.554.81.279 1.164zm.124-2.895c-3.575-2.126-9.475-2.32-12.903-1.26-.56.175-1.155-.14-1.33-.705-.175-.56.14-1.154.705-1.33 3.946-1.233 10.48-1 14.49 1.466.502.298.667.943.37 1.445-.297.502-.943.667-1.445.37z" />
    </svg>
  );

  return (
    <nav className="bg-white dark:bg-gray-800 text-gray-800 dark:text-gray-100 shadow-md fixed w-full top-0 left-0 z-50">
      <div className="max-w-7xl mx-auto px-4 py-3 flex justify-between items-center">
        <h1 className="text-xl font-bold text-blue-600 dark:text-blue-400">Diogo Carvalho</h1>

        <ul className="hidden md:flex flex-1 justify-center space-x-6">
          <li><Link to="/" className="hover:text-blue-500">Home</Link></li>
          <li><Link to="/about" className="hover:text-blue-500">About</Link></li>
          <li><Link to="/projects" className="hover:text-blue-500">Projects</Link></li>
          <li><Link to="/contact" className="hover:text-blue-500">Contact</Link></li>
        </ul>

        <div className="hidden md:flex items-center space-x-4">
          <a href="https://www.instagram.com/diogo___carvalho8/" target="_blank" rel="noreferrer"><Instagram /></a>
          <a href="https://www.linkedin.com/in/diogoadcarvalho/" target="_blank" rel="noreferrer"><Linkedin /></a>
          <a href="https://github.com/DiogoCarvalho999" target="_blank" rel="noreferrer"><Github /></a>
          <a href="https://open.spotify.com/user/odiogoegay" target="_blank" rel="noreferrer">{spotifyIcon}</a>
          <button onClick={() => setDarkMode(!darkMode)} className="ml-2 text-sm px-2 py-1 border rounded">
            {darkMode ? '☀️ Light' : '🌙 Dark'}
          </button>
        </div>

        <button className="md:hidden" onClick={() => setMobileOpen(!mobileOpen)}>
          {mobileOpen ? <X /> : <Menu />}
        </button>
      </div>

      {mobileOpen && (
        <div className="md:hidden px-4 pt-2 pb-4 space-y-2 bg-blue-500 text-white">
          <ul className="space-y-2">
            <li><Link to="/" className="block hover:underline">Home</Link></li>
            <li><Link to="/about" className="block hover:underline">About</Link></li>
            <li><Link to="/projects" className="block hover:underline">Projects</Link></li>
            <li><Link to="/contact" className="block hover:underline">Contact</Link></li>
          </ul>
        </div>
      )}
    </nav>
  );
};

export default NavBar;



