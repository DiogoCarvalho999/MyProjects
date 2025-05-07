import { Github, Instagram, Linkedin } from 'lucide-react';

const Footer = () => {
  const spotifyIcon = (
    <svg
      xmlns="http://www.w3.org/2000/svg"
      width="24"
      height="24"
      fill="currentColor"
      viewBox="0 0 24 24"
    >
      <path d="M12 0C5.373 0 .001 5.373.001 12c0 6.627 5.372 12 11.999 12 6.627 0 12-5.373 12-12 .001-6.627-5.372-12-11.999-12zM17.3 17.473c-.205.34-.637.447-.977.243-2.677-1.618-6.054-1.98-10.04-1.078-.39.09-.78-.16-.87-.55-.09-.39.16-.78.55-.87 4.41-.993 8.26-.587 11.262 1.247.34.204.446.637.243.978zm1.404-2.805c-.26.422-.81.553-1.232.292-3.07-1.895-7.748-2.446-11.366-1.33-.473.145-.98-.11-1.124-.58-.146-.47.108-.98.58-1.124 4.13-1.27 9.338-.645 12.863 1.578.423.26.554.81.279 1.164zm.124-2.895c-3.575-2.126-9.475-2.32-12.903-1.26-.56.175-1.155-.14-1.33-.705-.175-.56.14-1.154.705-1.33 3.946-1.233 10.48-1 14.49 1.466.502.298.667.943.37 1.445-.297.502-.943.667-1.445.37z" />
    </svg>
  );

  return (
    <footer className="bg-blue-600 dark:bg-gray-800 text-white dark:text-gray-200 py-6 px-4">
      <div className="max-w-6xl mx-auto flex flex-col md:flex-row justify-between items-center space-y-4 md:space-y-0">
        {/* Copyright */}
        <p className="text-sm">&copy; {new Date().getFullYear()} Diogo Carvalho. All rights reserved.</p>

        {/* Social Icons */}
        <div className="flex space-x-4">
          <a href="https://www.instagram.com/diogo___carvalho8/" target="_blank" rel="noreferrer" className="hover:text-gray-300">
            <Instagram />
          </a>
          <a href="https://www.linkedin.com/in/diogoadcarvalho/" target="_blank" rel="noreferrer" className="hover:text-gray-300">
            <Linkedin />
          </a>
          <a href="https://github.com/DiogoCarvalho999" target="_blank" rel="noreferrer" className="hover:text-gray-300">
            <Github />
          </a>
          <a href="https://open.spotify.com/user/odiogoegay?si=e326c19f0e2a4680" target="_blank" rel="noreferrer" className="hover:text-gray-300">
            {spotifyIcon}
          </a>
        </div>
      </div>
    </footer>
  );
};

export default Footer;
