# Java Grid Painter 🎨

A terminal-based interactive grid built with Java and the [SimpleGraphics](https://github.com/academia-de-codigo/simple-graphics) library. This application allows the user to move a cursor around a grid, paint cells, and save/load drawings to/from a file.

---

## 🚀 Features

- Paint and unpaint cells using keyboard input
- Save drawings to a `.txt` file
- Load previous drawings
- Clear all painted cells
- Simple graphics interface using an external library

---

## 🎮 Controls (Keyboard Shortcuts)

| Key       | Action                     |
|-----------|----------------------------|
| ⬅️⬆️➡️⬇️  | Move the cursor             |
| Space     | Paint/unpaint current cell |
| `C`       | Clear all painted cells    |
| `S`       | Save drawing               |
| `L`       | Load saved drawing         |

---

## 🛠️ Technologies Used

- Java 17
- [`SimpleGraphics`](https://github.com/academia-de-codigo/simple-graphics) (external graphics library)
- File I/O
- Event-driven keyboard input

---

## 📁 Project Structure
```
GridPainter/
├── io/
│ └── codeforall/
│ └── kernelfc/
│ ├── Grid/
│ │ └── Grid.java
│ ├── DrawingFiles/
│ │ └── drawing.txt
│ └── Main.java
```

---

## ▶️ How to Run

1. **Clone the repository** and make sure you have Java 17 installed.

2. **Download and add the SimpleGraphics JAR** to your project:
   - Link: [SimpleGraphics JAR](https://github.com/academia-de-codigo/simple-graphics)

3. **Compile:**

```bash
javac -cp path/to/simplegraphics.jar io/codeforall/kernelfc/Main.java
```
4. Run:
```
java -cp .:path/to/simplegraphics.jar io.codeforall.kernelfc.Main
```
(on Windows, replace : with ; in the classpath)

💾 Saving Drawings
Drawings are saved as a list of coordinates in:

src/io/codeforall/kernelfc/DrawingFiles/drawing.txt
Each line corresponds to one painted cell's X and Y coordinates.

📸 Screenshots 

![Screenshot at 16-23-11](https://github.com/user-attachments/assets/71e8521f-9ac0-4224-891d-1ffc097e836f)
