# HelloApp — 云端构建最小示例

这是给 GitHub Actions 用的最小可编译 Android 工程，用来验证云端出包流程。

## 目录

```
hello-app/
├── .github/workflows/build.yml   云端构建说明（核心）
├── settings.gradle.kts
├── build.gradle.kts
├── gradle.properties
├── .gitignore
└── app/
    ├── build.gradle.kts
    └── src/main/
        ├── AndroidManifest.xml
        └── java/com/example/hello/MainActivity.kt
```

## 怎么用

1. 在 GitHub 建一个 **Public** 仓库（公开仓库 Actions 免费不限时长）
2. 把本目录所有文件上传（网页拖拽即可，注意 `.github` 目录也要传）
3. 上传后自动开始构建，看仓库顶部 **Actions**
4. 跑完点进那次运行，页面底部 **Artifacts** 下载 `hello-app-debug`

## 说明

- 不需要本地装 JDK / SDK / NDK，全部在 GitHub 的 x86_64 机器上跑
- `aapt2`、`zipalign` 这些在 arm64 手机上跑不了的东西，云端没有这个问题
- 工程故意做成零第三方依赖（`Activity` + `TextView`），构建最快，也最容易排查
- 首次构建约 3–5 分钟，主要是下载 Gradle 和 AGP

## 常见失败

| 现象 | 原因 |
|---|---|
| `gradlew: Permission denied` | 本工程不用 gradlew，用的是 `gradle` 命令，不会遇到 |
| `SDK location not found` | 缺 `local.properties`；云端镜像自带 SDK，不需要该文件 |
| `Unsupported class file major version` | JDK 版本与 AGP 不匹配，确认 yml 里是 17 |
