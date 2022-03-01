
    /**
     *
     * This can call file
     *
     * getYamlFile("config").getString("")
     *
     * @param fileName file name of file you want to operate
     * @return
     */
    @SneakyThrows
    public Configuration getYamlFile(String fileName) {
        Configuration config = ConfigurationProvider
                .getProvider(YamlConfiguration.class)
                .load(new File(Bungee.getInstance().getDataFolder(), fileName + ".yml"));
        return config;
    }


    /**
     *
     * Here you can save configs
     *
     * saveYamlFiles("")
     *
     * @param fileNames names of files
     */
    @SneakyThrows
    public void saveYamlFiles(String... fileNames) {
        for (String fileName : fileNames) {
            Configuration yamlFile = ConfigurationProvider
                    .getProvider(YamlConfiguration.class)
                    .load(new File(Bungee.getInstance().getDataFolder(), fileName + ".yml"));
        }
    }

    /**
     * You can use it for copy to Bungee folder
     * createNewYamlFiles(files names | "config", "messages")
     *
     * @param fileNameData name of file
     */
    public void createNewYamlFiles(String... fileNameData) {
        if (!Bungee.getInstance().getDataFolder().exists())
            Bungee.getInstance().getDataFolder().mkdir();

        for (String fileName : fileNameData) {
            File file = new File(Bungee.getInstance().getDataFolder(), fileName + ".yml");

            if (!file.exists()) {
                try (InputStream in = Bungee.getInstance().getResourceAsStream(fileName + ".yml")) {
                    Files.copy(in, file.toPath());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


