
# 🧪 Automation Testing – Web UI dan API

Proyek ini adalah kombinasi pengujian otomatis **Web UI** dan **API** yang dikembangkan dengan menggunakan bahasa **Java**, **framework Cucumber**, dan build tool **Gradle**. Tujuan dari proyek ini adalah untuk membangun framework yang terstruktur, reusable, dan dapat dijalankan secara otomatis melalui **GitHub Actions**.

---

## 📂 Struktur Direktori

.
├── .github/workflows/
│   ├── api-test.yml        # GitHub Actions untuk API
│   └── ui-test.yml         # GitHub Actions untuk UI
├── src/test/java/
│   ├── api/
│   │   ├── stepdefinitions/
│   │   └── tests/
│   ├── ui/
│   │   ├── pages/
│   │   ├── stepdefinitions/
│   │   └── tests/
├── src/test/resources/
│   └── features/
│       ├── api/
│       └── ui/
├── build.gradle
├── gradle.properties
└── README.md

---

## 🛠️ Tools dan Library yang Digunakan

| Tools/Library      | Keterangan                                 |
|--------------------|--------------------------------------------|
| Java               | Bahasa pemrograman utama                   |
| Gradle             | Build automation tool                      |
| Cucumber           | Framework BDD (Behavior Driven Development)|
| Selenium WebDriver | Otomasi pengujian Web UI                   |
| Rest Assured       | Otomasi pengujian REST API                 |
| JUnit              | Test runner untuk Cucumber                 |
| GitHub Actions     | CI/CD workflow untuk test otomatis         |

---

## 🌐 Target Pengujian

### Web UI
- Website: https://www.demoblaze.com  
  (Alternatif jika down: https://www.saucedemo.com)

### API (DummyAPI.io)
- Endpoint:
  - Get, Create, Update, Delete User
  - Get List of Tags
- App-ID (untuk header):
  63a804408eb0cb069b57e43a

---

## ▶️ Cara Menjalankan Test

### Menjalankan Test UI secara lokal:
./gradlew clean test --tests * --info -Dcucumber.filter.tags="@ui"

### Menjalankan Test API secara lokal:
./gradlew clean test --tests * --info -Dcucumber.filter.tags="@api"

> Pastikan sudah mengatur driver dan koneksi internet untuk tes Web UI.

---

## 🤖 CI/CD - GitHub Actions

Test akan berjalan secara otomatis ketika:
- Ada Pull Request ke branch main
- Manual trigger dari tab Actions di GitHub

### File Workflow:
- .github/workflows/api-test.yml → Menjalankan test untuk API
- .github/workflows/ui-test.yml → Menjalankan test untuk Web UI

---

## 📊 Laporan Hasil Test

Setelah menjalankan tes, hasil laporan akan tersedia dalam format:
- HTML
- JSON

📁 Lokasi default:
build/reports/cucumber/

---

## ✅ Fitur yang Diimplementasikan

- [x] Automasi test Web UI menggunakan Page Object Model
- [x] Automasi test API menggunakan Rest Assured
- [x] Gherkin syntax pada semua test case
- [x] Validasi response pada API
- [x] Test terpisah menggunakan tag @api dan @ui
- [x] GitHub Actions untuk CI/CD
- [x] Laporan test HTML & JSON
